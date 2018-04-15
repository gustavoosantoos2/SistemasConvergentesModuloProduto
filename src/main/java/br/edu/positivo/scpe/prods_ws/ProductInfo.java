//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.04.15 às 02:18:56 PM BRT 
//


package br.edu.positivo.scpe.prods_ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de productInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="productInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="unityType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="unitBuyValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productInfo", propOrder = {
    "id",
    "description",
    "unityType",
    "unityBuyValue",
    "quantity"
})
public class ProductInfo {

    protected int id;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String unityType;
    @XmlElement(required = true)
    protected double unityBuyValue;
    @XmlElement(required = true)
    protected double quantity;

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade unityType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnityType() {
        return unityType;
    }

    /**
     * Define o valor da propriedade unityType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnityType(String value) {
        this.unityType = value;
    }

    /**
     * Obtém o valor da propriedade unitBuyValue.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public double getUnityBuyValue() {
        return unityBuyValue;
    }

    /**
     * Define o valor da propriedade unitBuyValue.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnityBuyValue(double value) {
        this.unityBuyValue = value;
    }

    /**
     * Obtém o valor da propriedade quantity.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Define o valor da propriedade quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantity(double value) {
        this.quantity = value;
    }

}
