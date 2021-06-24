package michiganstateuniversity.apps.restexample.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class AssetDTO
{
    private int syscode;
    private String code;
    private String description;
    private AssetPropertyDTO property;
    private AssetFloorDTO floor;
    private AssetSpaceDTO space;
    private AssetDepartmentDTO department;
    private AssetGroupDTO assetGroup;
    private AssetClassDTO assetClassification;
    private String assetTag;
    private AssetMainDTO mainAsset;
    private AssetStandardDTO standardAsset;
    private String photo;
    private AssetStatusDTO status;
    private String boType;
    private String brand;
    private String model;
    private AssetManufacturerDTO manufacturer;
    private Boolean isMissing;
    private Date inServiceDate;
    private BigDecimal quantity;
    private AssetAttributeSetDTO attributeSet;
    private ArrayList<AttributeDTO> attributes;
    private Boolean isSimple;
    private Boolean isArchived;
    private String createdBy;
    private Date creationDate;
    private Date modifiedOn;

    /**
     * @return the syscode
     */
    public int getSyscode() {
        return syscode;
    }

    /**
     * @param aPersonSyscode the syscode to set
     */
    public void setSyscode(final int aSyscode) {
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
     * @return the Property
     */
    public AssetPropertyDTO getProperty() {
        return property;
    }

    /**
     * @param aProperty the Property to set
     */
    public void setProperty(final AssetPropertyDTO aProperty) {
        property = aProperty;
    }

    /**
     * @return the Floor
     */
    public AssetFloorDTO getFloor() {
        return floor;
    }

    /**
     * @param aFloor the Floor to set
     */
    public void setFloor(final AssetFloorDTO aFloor) {
        floor = aFloor;
    }

    /**
     * @return the Space
     */
    public AssetSpaceDTO getSpace() {
        return space;
    }

    /**
     * @param aSpace the Space to set
     */
    public void setSpace(final AssetSpaceDTO aSpace) {
        space = aSpace;
    }

    /**
     * @return the Department
     */
    public AssetDepartmentDTO getDepartment() {
        return department;
    }

    /**
     * @param aDepartment the Department to set
     */
    public void setDepartment(final AssetDepartmentDTO aDepartment) {
        department = aDepartment;
    }

    /**
     * @return the AssetGroup
     */
    public AssetGroupDTO getAssetGroup() {
        return assetGroup;
    }

    /**
     * @param aAssetGroup the AssetGroup to set
     */
    public void setAssetGroup(final AssetGroupDTO aAssetGroup) {
        assetGroup = aAssetGroup;
    }

    /**
     * @return the AssetClassification
     */
    public AssetClassDTO getAssetClassification() {
        return assetClassification;
    }

    /**
     * @param aAssetClassification the AssetClassification to set
     */
    public void setAssetClassification(final AssetClassDTO aAssetClassification) {
        assetClassification = aAssetClassification;
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
     * @return the MainAsset
     */
    public AssetMainDTO getMainAsset() {
        return mainAsset;
    }

    /**
     * @param aMainAsset the MainAsset to set
     */
    public void setMainAsset(final AssetMainDTO aMainAsset) {
        mainAsset = aMainAsset;
    }

    /**
     * @return the StandardAsset
     */
    public AssetStandardDTO getStandardAsset() {
        return standardAsset;
    }

    /**
     * @param aStandardAsset the StandardAsset to set
     */
    public void setStandardAsset(final AssetStandardDTO aStandardAsset) {
        standardAsset = aStandardAsset;
    }

    /**
     * @return the Photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param aPhoto the Photo to set
     */
    public void setPhoto(final String aPhoto) {
        photo = aPhoto;
    }

    /**
     * @return the Status
     */
    public AssetStatusDTO getStatus() {
        return status;
    }

    /**
     * @param aStatus the Status to set
     */
    public void setStatus(final AssetStatusDTO aStatus) {
        status = aStatus;
    }

    /**
     * @return the BoType
     */
    public String getBoType() {
        return boType;
    }

    /**
     * @param aBoType the BoType to set
     */
    public void setBoType(final String aBoType) {
        boType = aBoType;
    }

    /**
     * @return the Brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param aBrand the Brand to set
     */
    public void setBrand(final String aBrand) {
        brand = aBrand;
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
     * @return the Manufacturer
     */
    public AssetManufacturerDTO getManufacturer() {
        return manufacturer;
    }

    /**
     * @param aManufacturer the Manufacturer to set
     */
    public void setManufacturer(final AssetManufacturerDTO aManufacturer) {
        manufacturer = aManufacturer;
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
     * @return the Quantity
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * @param aQuantity the Quantity to set
     */
    public void setQuantity(final BigDecimal aQuantity) {
        quantity = aQuantity;
    }

    /**
     * @return the AttributeSet
     */
    public AssetAttributeSetDTO getAttributeSet() {
        return attributeSet;
    }

    /**
     * @param aAttributeSet the AttributeSet to set
     */
    public void setAttributeSet(final AssetAttributeSetDTO aAttributeSet) {
        attributeSet = aAttributeSet;
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

    /**
     * @return the IsSimple
     */
    public Boolean getIsSimple() {
        return isSimple;
    }

    /**
     * @param aIsSimple the IsSimple to set
     */
    public void setIsSimple(final Boolean aIsSimple) {
        isSimple = aIsSimple;
    }

    /**
     * @return the IsArchived
     */
    public Boolean getIsArchived() {
        return isArchived;
    }

    /**
     * @param aIsArchived the IsArchived to set
     */
    public void setIsArchived(final Boolean aIsArchived) {
        isArchived = aIsArchived;
    }

    /**
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param aCreatedBy the CreatedBy to set
     */
    public void setCreatedBy(final String aCreatedBy) {
        createdBy = aCreatedBy;
    }

    /**
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param aCreationDate the CreationDate to set
     */
    public void setCreationDate(final Date aCreationDate) {
        creationDate = aCreationDate;
    }

    /**
     * @return the ModifiedOn
     */
    public Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * @param aModifiedOn the ModifiedOn to set
     */
    public void setModifiedOn(final Date aModifiedOn) {
        modifiedOn = aModifiedOn;
    }

}