package michiganstateuniversity.apps.restexample.dto;

import java.util.ArrayList;
import java.util.Date;

public class AssetUpdateDTO
{
    private Integer syscode;
    private String code;
    private String description;
    private Integer mainAsset;
    private String status;
    private Boolean isMissing;
    private Integer assetClassification;
    private Integer assetGroup;
    private Integer property;
    private Integer floor;
    private Integer space;
    private Integer manufacturer;
    private String model;
    private String assetTag;
    private Date inServiceDate;
    private ArrayList<AttributeDTO> attributes;

    /**
     * @return the syscode
     */
    public Integer getSyscode() {
        return syscode;
    }

    /**
     * @param aSyscode the syscode to set
     */
    public void setSyscode(final Integer aSyscode) {
        syscode = aSyscode;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param aCode the Code to set
     */
    public void setCode(final String aCode) {
        code = aCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param aDescription the description to set
     */
    public void setDescription(final String aDescription) {
        description = aDescription;
    }

    /**
     * @return the mainAsset
     */
    public Integer getMainAsset() {
        return mainAsset;
    }

    /**
     * @param aMainAsset the MainAsset to set
     */
    public void setMainAsset(final Integer aMainAsset) {
        mainAsset = aMainAsset;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param aStatus the Status to set
     */
    public void setStatus(final String aStatus) {
        status = aStatus;
    }

    /**
     * @return the IsMissing
     */
    public Boolean getIsMissing() {
        return isMissing;
    }

    /**
     * @param aIsMissing the IsMissing to set
     */
    public void setIsMissing(final Boolean aIsMissing) {
        isMissing = aIsMissing;
    }

    /**
     * @return the AssetClassification
     */
    public Integer getAssetClassification() {
        return assetClassification;
    }

    /**
     * @param aAssetClassification the AssetClassification to set
     */
    public void setAssetClassification(final Integer aAssetClassification) {
        assetClassification = aAssetClassification;
    }

    /**
     * @return the AssetGroup
     */
    public Integer getAssetGroup() {
        return assetGroup;
    }

    /**
     * @param aAssetGroup the AssetGroup to set
     */
    public void setAssetGroup(final Integer aAssetGroup) {
        assetGroup = aAssetGroup;
    }

    /**
     * @return the Property
     */
    public Integer getProperty() {
        return property;
    }

    /**
     * @param aProperty the Property to set
     */
    public void setProperty(final Integer aProperty) {
        property = aProperty;
    }

    /**
     * @return the Floor
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * @param aFloor the Floor to set
     */
    public void setFloor(final Integer aFloor) {
        floor = aFloor;
    }

    /**
     * @return the Space
     */
    public Integer getSpace() {
        return space;
    }

    /**
     * @param aSpace the Space to set
     */
    public void setSpace(final Integer aSpace) {
        space = aSpace;
    }

    /**
     * @return the Manufacturer
     */
    public Integer getManufacturer() {
        return manufacturer;
    }

    /**
     * @param aManufacturer the Manufacturer to set
     */
    public void setManufacturer(final Integer aManufacturer) {
        manufacturer = aManufacturer;
    }

    /**
     * @return the Model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param aModel the Model to set
     */
    public void setModel(final String aModel) {
        model = aModel;
    }

    /**
     * @return the AssetTag
     */
    public String getAssetTag() {
        return assetTag;
    }

    /**
     * @param aAssetTag the AssetTag to set
     */
    public void setAssetTag(final String aAssetTag) {
        assetTag = aAssetTag;
    }

    /**
     * @return the InServiceDate
     */
    public Date getInServiceDate() {
        return inServiceDate;
    }

    /**
     * @param aInServiceDate the InServiceDate to set
     */
    public void setInServiceDate(final Date aInServiceDate) {
        inServiceDate = aInServiceDate;
    }

    /**
     * @return the Attributes
     */
    public ArrayList<AttributeDTO> getAttributes() {
        return attributes;
    }

    /**
     * @param aAttributes the Attributes to set
     */
    public void setAttributes(final ArrayList<AttributeDTO> aAttributes) {
        attributes = aAttributes;
    }

}