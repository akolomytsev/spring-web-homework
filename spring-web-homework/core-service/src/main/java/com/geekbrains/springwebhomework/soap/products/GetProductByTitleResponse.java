//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.23 at 09:49:50 PM OMST 
//


package com.geekbrains.springwebhomework.soap.products;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="product1" type="{http://www.com/geekbrains/springwebhomework/products}product1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "product1"
})
@XmlRootElement(name = "getProductByTitleResponse")
public class GetProductByTitleResponse {

    @XmlElement(required = true)
    protected Product1 product1;

    /**
     * Gets the value of the product1 property.
     * 
     * @return
     *     possible object is
     *     {@link Product1 }
     *     
     */
    public Product1 getProduct1() {
        return product1;
    }

    /**
     * Sets the value of the product1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product1 }
     *     
     */
    public void setProduct1(Product1 value) {
        this.product1 = value;
    }

}