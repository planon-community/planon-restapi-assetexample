package michiganstateuniversity.apps.restexample.dto;

import com.planonsoftware.platform.data.v1.AttributeType;

public class AttributeDTO
{
    private String code;
    private Object value;
    private String label;
    private AttributeType attributeType;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param aCode the code to set
     */
    public void setCode(final String aCode) {
        code = aCode;
    }

    /**
     * @return the Value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param object the Value to set
     */
    public void setValue(final Object aValue) {
        value = aValue;
    }

    /**
     * @return the Label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param aLabel the label to set
     */
    public void setLabel(final String aLabel) {
        label = aLabel;
    }

    /**
     * @return the attributeType
     */
    public AttributeType getAttributeType() {
        return attributeType;
    }

    /**
     * @param aAttributeType the AttributeType to set
     */
    public void setAttributeType(final AttributeType aAttributeType) {
        attributeType = aAttributeType;
    }

}