package br.edu.positivo.scpe.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.edu.positivo.scpe.entity.IProductService;
import br.edu.positivo.scpe.entity.Product;
import br.edu.positivo.scpe.entity.StatusMessage;
import br.edu.positivo.scpe.prods_ws.AddProductResponse;
import br.edu.positivo.scpe.prods_ws.DeleteProductResponse;
import br.edu.positivo.scpe.prods_ws.GetAllProductsResponse;
import br.edu.positivo.scpe.prods_ws.GetProductByDescriptionResponse;
import br.edu.positivo.scpe.prods_ws.ProductInfo;
import br.edu.positivo.scpe.prods_ws.ServiceStatus;
import br.edu.positivo.scpe.prods_ws.UpdateProductDescriptionResponse;
import br.edu.positivo.scpe.prods_ws.UpdateProductQuantityResponse;

@Endpoint
public class ProductEndpoint {

	private static final String NAMESPACE_URI = "http://scpe.positivo.edu.br/product-ws";
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IProductService service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProductRequest")
	@ResponsePayload
	public AddProductResponse addProduct(@RequestPayload ProductInfo productInfo) {
		Product product = new Product();
		BeanUtils.copyProperties(productInfo, product);
		log.debug("Product: " + product.getQuantity() + " " + product.getUnityBuyValue());
		log.debug("ProductInfo: " + productInfo.getQuantity() + " " + productInfo.getUnityBuyValue());
		
		ServiceStatus status = null;

		if (service.addProduct(product)) {
			status = StatusMessage.CreateMessage("CREATED", "The product has been created successfully.");
		} else {
			status = StatusMessage.CreateMessage("BAD REQUEST", "Error while creating product.");
		}

		AddProductResponse response = new AddProductResponse();
		response.setProductInfo(productInfo);
		response.setServiceStatus(status);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
	@ResponsePayload
	public DeleteProductResponse deleteProduct(@RequestPayload ProductInfo info) {
		ServiceStatus status = null;
		Product product = service.getProductById(info.getId());

		if (product == null)
			status = StatusMessage.CreateMessage("NOT FOUND", "No product founded with sent id.");
		else {
			service.deleteProduct(product);
			status = StatusMessage.CreateMessage("OK", "The product was removed successfully.");
		}

		DeleteProductResponse response = new DeleteProductResponse();
		response.setServiceStatus(status);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
	@ResponsePayload
	public GetAllProductsResponse getAll() {
		List<ProductInfo> productsInfo = service.getAllProducts().stream().map(e -> {
			ProductInfo info = new ProductInfo();
			BeanUtils.copyProperties(e, info);
			return info;
		}).collect(Collectors.toList());

		GetAllProductsResponse response = new GetAllProductsResponse();
		response.getProductInfo().addAll(productsInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
	@ResponsePayload
	public GetProductByDescriptionResponse getProductById(@RequestPayload ProductInfo info) {
		Product product = service.getProductById(info.getId());
		ProductInfo productInfo = new ProductInfo();
		BeanUtils.copyProperties(product, productInfo);

		GetProductByDescriptionResponse response = new GetProductByDescriptionResponse();
		response.setProductInfo(productInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByDescriptionRequest")
	@ResponsePayload
	public GetProductByDescriptionResponse getProductByDescription(@RequestPayload ProductInfo info) {
		Product product = service.getProductByDescription(info.getDescription());
		ProductInfo productInfo = new ProductInfo();
		BeanUtils.copyProperties(product, productInfo);

		GetProductByDescriptionResponse response = new GetProductByDescriptionResponse();
		response.setProductInfo(productInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductQuantityRequest")
	@ResponsePayload
	public UpdateProductQuantityResponse updateProductQuantity(@RequestPayload ProductInfo info) {
		Product product = service.getProductById(info.getId());
		ProductInfo productInfo = new ProductInfo();
		ServiceStatus status = null;

		if (product == null) {
			status = StatusMessage.CreateMessage("NOT FOUND",
					"No product founded with sent id.");

			UpdateProductQuantityResponse response = new UpdateProductQuantityResponse();
			response.setServiceStatus(status);
			return response;
		}
		status = StatusMessage.CreateMessage("OK", "Product updated successfully.");
		product.setQuantity(info.getQuantity());
		service.updateProduct(product);

		UpdateProductQuantityResponse response = new UpdateProductQuantityResponse();
		response.setProductInfo(productInfo);
		response.setServiceStatus(status);
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductDescriptionRequest")
	@ResponsePayload
	public UpdateProductDescriptionResponse updateProductDescription(@RequestPayload ProductInfo info) {
		Product product = service.getProductById(info.getId());
		ProductInfo productInfo = new ProductInfo();
		ServiceStatus status = null;

		if (product == null) {
			status = StatusMessage.CreateMessage("NOT FOUND",
					"No product founded with sent id.");

			UpdateProductDescriptionResponse response = new UpdateProductDescriptionResponse();
			response.setServiceStatus(status);
			return response;
		}
		status = StatusMessage.CreateMessage("OK", "Product updated successfully.");
		product.setDescription(info.getDescription());
		service.updateProduct(product);

		UpdateProductDescriptionResponse response = new UpdateProductDescriptionResponse();
		response.setProductInfo(productInfo);
		response.setServiceStatus(status);
		
		return response;
	}
}
