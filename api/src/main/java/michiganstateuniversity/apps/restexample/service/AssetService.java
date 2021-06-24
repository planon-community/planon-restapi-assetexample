package michiganstateuniversity.apps.restexample.service;

import com.planonsoftware.platform.data.v1.ActionNotFoundException;
import com.planonsoftware.platform.data.v1.AttributeNotFoundException;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IAction;
import com.planonsoftware.platform.data.v1.IActionListManager;
import com.planonsoftware.platform.data.v1.IAttribute;
import com.planonsoftware.platform.data.v1.IAttributesValue;
import com.planonsoftware.platform.data.v1.IBusinessObject;
import com.planonsoftware.platform.data.v1.IDataService;
import com.planonsoftware.platform.data.v1.IDatabaseQuery;
import com.planonsoftware.platform.data.v1.IResultSet;
import com.planonsoftware.platform.data.v1.IStateChange;
import com.planonsoftware.platform.data.v1.Operator;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import michiganstateuniversity.apps.restexample.dto.AssetAttributeSetDTO;
import michiganstateuniversity.apps.restexample.dto.AssetClassDTO;
import michiganstateuniversity.apps.restexample.dto.AssetCreateDTO;
import michiganstateuniversity.apps.restexample.dto.AssetDTO;
import michiganstateuniversity.apps.restexample.dto.AssetDepartmentDTO;
import michiganstateuniversity.apps.restexample.dto.AssetFloorDTO;
import michiganstateuniversity.apps.restexample.dto.AssetGroupDTO;
import michiganstateuniversity.apps.restexample.dto.AssetMainDTO;
import michiganstateuniversity.apps.restexample.dto.AssetManufacturerDTO;
import michiganstateuniversity.apps.restexample.dto.AssetPropertyDTO;
import michiganstateuniversity.apps.restexample.dto.AssetSpaceDTO;
import michiganstateuniversity.apps.restexample.dto.AssetStandardDTO;
import michiganstateuniversity.apps.restexample.dto.AssetStatusDTO;
import michiganstateuniversity.apps.restexample.dto.AssetUpdateDTO;
import michiganstateuniversity.apps.restexample.dto.AttributeDTO;

public class AssetService
{
    public ArrayList<AssetDTO> getAssets(final IDataService dataService, final Integer syscode, final String assetCode, final String description, final String status, final String assetGroup, final String assetClass, final String manufacturer, final String model, final String assetTag, final String property, final String floor, final String space) throws BusinessException, FieldNotFoundException, IllegalStateException, ActionNotFoundException, IOException {
        System.out.println("AssetService: getAssets");
        
        ArrayList<AssetDTO> assets = new ArrayList<AssetDTO>();
        if (syscode == null && assetCode == null && description == null && status == null && assetGroup == null && assetClass == null && manufacturer == null && model == null && assetTag == null && property == null && floor == null && space == null) {
            IDatabaseQuery query = dataService.getPVDatabaseQuery("AssetDetailsQuery");
            query.getSearchExpression("assetCode", Operator.NOT_NULL);   

            IResultSet resultset = query.execute();
            System.out.println("Query Executed successfully...");

            
            while(resultset.next())
            {
                AssetDTO asset = loadAssetRecords(dataService, resultset);
                assets.add(asset);
            }
        }
        if (syscode != null || assetCode != null || description != null || status != null || assetGroup != null || assetClass != null || manufacturer != null || model != null || assetTag != null || property != null || floor != null || space != null) {
            IDatabaseQuery query = dataService.getPVDatabaseQuery("AssetDetailsQuery");
            if (syscode != null) {query.getIntegerSearchExpression("syscode", Operator.EQUAL).addValue(syscode);}
            if (assetCode != null) {query.getStringSearchExpression("assetCode", Operator.CONTAINS).addValue(assetCode);}
            if (description != null) {query.getStringSearchExpression("description", Operator.CONTAINS).addValue(description);}
            if (status != null) {query.getStringSearchExpression("status", Operator.EQUAL).addValue(status);}
            if (assetGroup != null) {query.getStringSearchExpression("assetGroup", Operator.EQUAL).addValue(assetGroup);}
            if (assetClass != null) {query.getStringSearchExpression("assetClass", Operator.EQUAL).addValue(assetClass);}
            if (manufacturer != null) {query.getStringSearchExpression("manufacturer", Operator.EQUAL).addValue(manufacturer);}
            if (model != null) {query.getStringSearchExpression("model", Operator.CONTAINS).addValue(model);}
            if (assetTag != null) {query.getStringSearchExpression("assetTag", Operator.CONTAINS).addValue(assetTag);}
            if (property != null) {query.getStringSearchExpression("property", Operator.EQUAL).addValue(property);}
            if (floor != null) {query.getStringSearchExpression("floor", Operator.EQUAL).addValue(floor);}
            if (space != null) {query.getStringSearchExpression("space", Operator.EQUAL).addValue(space);} 

            IResultSet resultset = query.execute();
            System.out.println("Query Executed successfully...");

            
            while(resultset.next())
            {
                AssetDTO asset = loadAssetRecords(dataService, resultset);
                assets.add(asset);
            }
        }
        
        return assets;
    }

    public AssetDTO getAssetByCode(final IDataService dataService, final String assetCode) throws BusinessException, FieldNotFoundException, IllegalStateException, ActionNotFoundException, IOException {
        System.out.println("AssetService: getAssetByCode "+assetCode);
        
        IDatabaseQuery query = dataService.getPVDatabaseQuery("AssetDetailsQuery");
        query.getSearchExpression("assetCode", Operator.EQUAL).addValue(assetCode);     

        IResultSet resultset = query.execute();
        System.out.println("Query Executed successfully...");
        AssetDTO asset = loadAssetRecord(dataService, resultset);    

        return asset; 
    }

    public AssetUpdateDTO getAssetUpdateByCode(final IDataService dataService, final String assetCode) throws BusinessException, FieldNotFoundException, IllegalStateException, ActionNotFoundException, IOException {
        System.out.println("AssetService: getAssetByCode "+assetCode);
        
        IDatabaseQuery query = dataService.getPVDatabaseQuery("AssetDetailsQuery");
        query.getSearchExpression("assetCode", Operator.EQUAL).addValue(assetCode);     

        IResultSet resultset = query.execute();
        System.out.println("Query Executed successfully...");
        AssetUpdateDTO asset = loadAssetUpdateRecord(dataService, resultset);    

        return asset; 
    }

    private AssetDTO loadAssetRecords(final IDataService dataService, final IResultSet resultset) throws IllegalStateException, FieldNotFoundException, BusinessException, ActionNotFoundException, IOException {
        AssetDTO asset = null;
        
        asset = new AssetDTO();
        asset.setSyscode(resultset.getPrimaryKey());
        asset.setCode(resultset.getString("Code"));
        asset.setDescription(resultset.getString("AssetDescription"));
        asset.setProperty(loadAssetPropertyValues(resultset));
        asset.setFloor(loadAssetFloorValues(resultset));
        asset.setSpace(loadAssetSpaceValues(resultset));
        asset.setDepartment(loadAssetDepartmentValues(resultset));
        asset.setAssetGroup(loadAssetGroupValues(resultset));
        asset.setAssetClassification(loadAssetClassValues(resultset));
        asset.setAssetTag(resultset.getString("AssetTagNumber"));
        asset.setMainAsset(loadAssetMainValues(resultset));
        asset.setStandardAsset(loadAssetStandardValues(resultset));
        asset.setPhoto(convertPhoto(dataService, resultset.getPrimaryKey()));
        asset.setStatus(loadAssetStatusValues(resultset));
        asset.setBoType(resultset.getString("boType"));
        asset.setBrand(resultset.getString("Brand"));
        asset.setModel(resultset.getString("ModelName"));
        asset.setManufacturer(loadAssetManufacturerValues(resultset));
        asset.setIsMissing(resultset.getBoolean("IsMissing"));
        asset.setInServiceDate(resultset.getDate("InServiceDate"));
        asset.setQuantity(resultset.getBigDecimal("Quantity"));
        asset.setAttributeSet(loadAssetAttributeSetValues(resultset));
        if (resultset.getAttributes("Attributes") != null) {
            asset.setAttributes(getAttributes(resultset.getAttributes("Attributes")));
        }
        asset.setIsSimple(resultset.getBoolean("IsSimple"));
        asset.setIsArchived(resultset.getBoolean("IsArchived"));
        asset.setCreatedBy(resultset.getString("CreatedBy"));
        asset.setCreationDate(resultset.getDateTime("CreatedOn"));
        asset.setModifiedOn(resultset.getDateTime("ModifiedOn"));

        return asset;
    }

    private AssetDTO loadAssetRecord(final IDataService dataService, final IResultSet resultset) throws IllegalStateException, FieldNotFoundException, BusinessException, ActionNotFoundException, IOException {
        AssetDTO asset = null;
        
        if(resultset.next()) { 
            asset = new AssetDTO();
            asset.setSyscode(resultset.getPrimaryKey());
            asset.setCode(resultset.getString("Code"));
            asset.setDescription(resultset.getString("AssetDescription"));
            asset.setProperty(loadAssetPropertyValues(resultset));
            asset.setFloor(loadAssetFloorValues(resultset));
            asset.setSpace(loadAssetSpaceValues(resultset));
            asset.setDepartment(loadAssetDepartmentValues(resultset));
            asset.setAssetGroup(loadAssetGroupValues(resultset));
            asset.setAssetClassification(loadAssetClassValues(resultset));
            asset.setAssetTag(resultset.getString("AssetTagNumber"));
            asset.setMainAsset(loadAssetMainValues(resultset));
            asset.setStandardAsset(loadAssetStandardValues(resultset));
            asset.setPhoto(convertPhoto(dataService, resultset.getPrimaryKey()));
            asset.setStatus(loadAssetStatusValues(resultset));
            asset.setBoType(resultset.getString("boType"));
            asset.setBrand(resultset.getString("Brand"));
            asset.setModel(resultset.getString("ModelName"));
            asset.setManufacturer(loadAssetManufacturerValues(resultset));
            asset.setIsMissing(resultset.getBoolean("IsMissing"));
            asset.setInServiceDate(resultset.getDate("InServiceDate"));
            asset.setQuantity(resultset.getBigDecimal("Quantity"));
            asset.setAttributeSet(loadAssetAttributeSetValues(resultset));
            if (resultset.getAttributes("Attributes") != null) {
                asset.setAttributes(getAttributes(resultset.getAttributes("Attributes")));
            }
            asset.setIsSimple(resultset.getBoolean("IsSimple"));
            asset.setIsArchived(resultset.getBoolean("IsArchived"));
            asset.setCreatedBy(resultset.getString("CreatedBy"));
            asset.setCreationDate(resultset.getDateTime("CreatedOn"));
            asset.setModifiedOn(resultset.getDateTime("ModifiedOn"));
        }

        return asset;
    }

    private AssetUpdateDTO loadAssetUpdateRecord(final IDataService dataService, final IResultSet resultset) throws IllegalStateException, FieldNotFoundException, BusinessException, ActionNotFoundException, IOException {
        AssetUpdateDTO asset = null;
        
        if(resultset.next()) { 
            asset = new AssetUpdateDTO();
            asset.setSyscode(resultset.getPrimaryKey());
            asset.setCode(resultset.getString("Code"));
            asset.setDescription(resultset.getString("AssetDescription"));
            asset.setStatus(resultset.getString("StatusName"));
            asset.setIsMissing(resultset.getBoolean("IsMissing"));
            asset.setAssetClassification(resultset.getInteger("AssetClassificationSyscode"));
            asset.setAssetGroup(resultset.getInteger("AssetGroupSyscode"));
            asset.setProperty(resultset.getInteger("PropertySyscode"));
            asset.setFloor(resultset.getInteger("FloorSyscode"));
            asset.setSpace(resultset.getInteger("SpaceSyscode"));
            asset.setManufacturer(resultset.getInteger("ManufacturerSyscode"));
            asset.setModel(resultset.getString("ModelName"));
            asset.setAssetTag(resultset.getString("AssetTagNumber"));
            asset.setInServiceDate(resultset.getDate("InServiceDate"));
            if (resultset.getAttributes("Attributes") != null) {
                asset.setAttributes(getAttributes(resultset.getAttributes("Attributes")));
            }
        }

        return asset;
    }

    public ArrayList<AttributeDTO> getAttributes(final IAttributesValue attributeSet) throws BusinessException, FieldNotFoundException, ActionNotFoundException {
        ArrayList<AttributeDTO> attributeValues = new ArrayList<AttributeDTO>();
        Iterator<IAttribute> attributes = attributeSet.iterator();
        while (attributes.hasNext()) {
            AttributeDTO attributeValue = loadAttributeRecords(attributes.next());
            attributeValues.add(attributeValue);
        }
        return attributeValues;
    }

    private AttributeDTO loadAttributeRecords(final IAttribute attributes) throws BusinessException {
        AttributeDTO attribute = null;

        attribute = new AttributeDTO();
        attribute.setCode(attributes.getCode());
        attribute.setValue(attributes.getValue());
        attribute.setLabel(attributes.getLabel());
        attribute.setAttributeType(attributes.getType());

        return attribute;
    }

    private AssetPropertyDTO loadAssetPropertyValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetPropertyDTO property = null;
        if (resultset.getInteger("PropertySyscode") != null) {
            property = new AssetPropertyDTO();
            property.setSyscode(resultset.getInteger("PropertySyscode"));
            property.setPropertyCode(resultset.getString("PropertyCode"));
            property.setCommonName(resultset.getString("CommonName"));
            property.setStatus(resultset.getString("PropertyStatus"));
        }

        return property;
    }

    private AssetFloorDTO loadAssetFloorValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetFloorDTO floor = null;
        if (resultset.getInteger("FloorSyscode") != null) {
            floor = new AssetFloorDTO();
            floor.setSyscode(resultset.getInteger("FloorSyscode"));
            floor.setFloorCode(resultset.getString("FloorCode"));
            floor.setName(resultset.getString("FloorName"));
            floor.setPropertyCode(resultset.getString("FloorProperty"));
        }

        return floor;
    }

    private AssetSpaceDTO loadAssetSpaceValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetSpaceDTO space = null;
        if (resultset.getInteger("SpaceSyscode") != null) {
            space = new AssetSpaceDTO();
            space.setSyscode(resultset.getInteger("SpaceSyscode"));
            space.setSpaceNumber(resultset.getString("SpaceCode"));
            space.setFloorCode(resultset.getString("SpaceFloor"));
        }

        return space;
    }

    private AssetDepartmentDTO loadAssetDepartmentValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetDepartmentDTO department = null;
        if (resultset.getInteger("DepartmentSyscode") != null) {
            department = new AssetDepartmentDTO();
            department.setSyscode(resultset.getInteger("DepartmentSyscode"));
            department.setCode(resultset.getString("DepartmentCode"));
            department.setCodeGroup(resultset.getString("DepartmentCodeGroup"));
            department.setDepartment(resultset.getString("DepartmentName"));
        }

        return department;
    }

    private AssetGroupDTO loadAssetGroupValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetGroupDTO assetGroup = null;
        if (resultset.getInteger("AssetGroupSyscode") != null) {
            assetGroup = new AssetGroupDTO();
            assetGroup.setSyscode(resultset.getInteger("AssetGroupSyscode"));
            assetGroup.setCode(resultset.getString("AssetGroupCode"));
            assetGroup.setName(resultset.getString("AssetGroupName"));
        }

        return assetGroup;
    }

    private AssetClassDTO loadAssetClassValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetClassDTO assetClass = null;
        if (resultset.getInteger("AssetClassificationSyscode") != null) {
            assetClass = new AssetClassDTO();
            assetClass.setSyscode(resultset.getInteger("AssetClassificationSyscode"));
            assetClass.setCode(resultset.getString("AssetClassificationCode"));
            assetClass.setDescription(resultset.getString("AssetClassificationName"));
        }

        return assetClass;
    }

    private AssetMainDTO loadAssetMainValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetMainDTO assetMain = null;
        if (resultset.getString("MainAssetCode") != null) {
            assetMain = new AssetMainDTO();
            assetMain.setCode(resultset.getString("MainAssetCode"));
            assetMain.setDescription(resultset.getString("MainAssetDescription"));
        }

        return assetMain;
    }

    private AssetStandardDTO loadAssetStandardValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetStandardDTO assetStandard = null;
        if (resultset.getInteger("StandardAssetSyscode") != null) {
            assetStandard = new AssetStandardDTO();
            assetStandard.setSyscode(resultset.getInteger("StandardAssetSyscode"));
            assetStandard.setCode(resultset.getString("StandardAssetCode"));
            assetStandard.setName(resultset.getString("StandardAssetName"));
        }

        return assetStandard;
    }

    private AssetStatusDTO loadAssetStatusValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetStatusDTO assetStatus = null;
        if (resultset.getInteger("StatusSyscode") != null) {
            assetStatus = new AssetStatusDTO();
            assetStatus.setSyscode(resultset.getInteger("StatusSyscode"));
            assetStatus.setCode(resultset.getString("StatusCode"));
            assetStatus.setName(resultset.getString("StatusName"));
        }

        return assetStatus;
    }

    private AssetManufacturerDTO loadAssetManufacturerValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetManufacturerDTO assetManufacturer = null;
        if (resultset.getInteger("ManufacturerSyscode") != null) {
            assetManufacturer = new AssetManufacturerDTO();
            assetManufacturer.setSyscode(resultset.getInteger("ManufacturerSyscode"));
            assetManufacturer.setCode(resultset.getString("ManufacturerCode"));
            assetManufacturer.setName(resultset.getString("ManufacturerName"));
        }

        return assetManufacturer;
    }

    private AssetAttributeSetDTO loadAssetAttributeSetValues(final IResultSet resultset) throws FieldNotFoundException {
        AssetAttributeSetDTO assetAttributeSet = null;
        if (resultset.getInteger("AttributeSetSyscode") != null) {
            assetAttributeSet = new AssetAttributeSetDTO();
            assetAttributeSet.setSyscode(resultset.getInteger("AttributeSetSyscode"));
            assetAttributeSet.setCode(resultset.getString("AttributeSetCode"));
            assetAttributeSet.setName(resultset.getString("AttributeSetName"));
        }

        return assetAttributeSet;
    }

    public static String convertPhoto(final IDataService dataService, final Integer aSyscode) throws BusinessException, ActionNotFoundException, FieldNotFoundException, IOException {
        IActionListManager actionList = dataService.getActionListManager("UsrAsset");
        IAction readAction = actionList.getReadAction(aSyscode);
        IBusinessObject assetBO = readAction.execute();
        String photo = null;
        
        ImageIcon image = assetBO.getImageFileField("PhotoRef").downloadContent();
        if (image != null) {
            photo = ConvertImageIconToBase64String(image);
        }

        return photo;
    }

    public static String ConvertImageIconToBase64String(ImageIcon ii) throws IOException {
        // Create a buffered image of the size of the original image icon
        BufferedImage image = new BufferedImage(ii.getIconWidth(),
        ii.getIconHeight(), BufferedImage.TYPE_INT_RGB);

        // Create a graphics object to draw the image 
        Graphics g = image.createGraphics();

        // Paint the icon on to the buffered image
        ii.paintIcon(null, g, 0, 0);
        g.dispose();

        // Convert the buffered image into a byte array
        ByteArrayOutputStream b = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "jpg", b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        byte[] imageInByte = b.toByteArray();
        b.close();
        // Return the Base64 encoded String        
        return Base64.getEncoder().encodeToString(imageInByte);
    }

    public void updateAssetDetailRecord(final IDataService dataService, final AssetUpdateDTO aAsset) throws ActionNotFoundException, BusinessException, FieldNotFoundException, AttributeNotFoundException, ParseException, IllegalStateException, IOException {
        IActionListManager actionListManager = dataService.getActionListManager("UsrAsset"); 
        IAction action = actionListManager.getReadAction(aAsset.getSyscode());
        IBusinessObject assetBO = action.execute();

        if(aAsset.getCode() != null) {
            System.out.println("Set Code for Asset to '" + aAsset.getCode() + "'");
            assetBO.getStringField("Code").setValue(aAsset.getCode());
        }
        if(aAsset.getDescription() != null) {
            System.out.println("Set Description for Asset to " + aAsset.getDescription());
            assetBO.getStringField("Name").setValue(aAsset.getDescription());
        }
        if(aAsset.getMainAsset() != null) {
            System.out.println("Set MainAsset for Asset to " + aAsset.getMainAsset());
            assetBO.getReferenceField("ParentRef").setValue(aAsset.getMainAsset());
        }
        if(aAsset.getStatus() != null) {
            System.out.println("Set Status for Asset to " + aAsset.getStatus());
            IStateChange aStatus = assetBO.getStateChange(aAsset.getStatus());
            assetBO = assetBO.executeStateChange(aStatus);
        }
        if(aAsset.getIsMissing() != null) {
            System.out.println("Set IsMissing for Asset to " + aAsset.getIsMissing());
            assetBO.getBooleanField("IsMissing").setValue(aAsset.getIsMissing());
        }
        if(aAsset.getAssetClassification() != null) {
            System.out.println("Set AssetClassification for Asset to " + aAsset.getAssetClassification());
            assetBO.getReferenceField("AssetClassificationRef").setValue(aAsset.getAssetClassification());
        }
        if(aAsset.getAssetGroup() != null) {
            System.out.println("Set AssetGroup for Asset to " + aAsset.getAssetGroup());
            assetBO.getReferenceField("ItemGroupRef").setValue(aAsset.getAssetGroup());
        }
        if(aAsset.getProperty() != null) {
            System.out.println("Set Property for Asset to " + aAsset.getProperty());
            assetBO.getReferenceField("PropertyRef").setValue(aAsset.getProperty());
        }
        if(aAsset.getFloor() != null) {
            System.out.println("Set Floor for Asset to " + aAsset.getFloor());
            assetBO.getIntegerField("FreeInteger1").setValue(aAsset.getFloor());
        }
        if(aAsset.getSpace() != null) {
            System.out.println("Set Space for Asset to " + aAsset.getSpace());
            assetBO.getReferenceField("SpaceRef").setValue(aAsset.getSpace());
        }
        if(aAsset.getManufacturer() != null) {
            System.out.println("Set Manufacturer for Asset  to " + aAsset.getManufacturer());
            assetBO.getStringField("FreeString35").setValue(aAsset.getManufacturer());
        }
        if(aAsset.getModel() != null) {
            System.out.println("Set Model for Asset to " + aAsset.getModel());
            assetBO.getStringField("Type").setValue(aAsset.getModel());
        }
        if(aAsset.getAssetTag() != null) {
            System.out.println("Set AssetTag for Asset to " + aAsset.getAssetTag());
            assetBO.getStringField("AssetTag").setValue(aAsset.getAssetTag());
        }
        if(aAsset.getInServiceDate() != null) {
            System.out.println("Set InServiceDate for Asset to " + aAsset.getInServiceDate());
            assetBO.getDateField("FirstUsedDate").setValue(aAsset.getInServiceDate());
        }
        if(aAsset.getAttributes() != null) {
            IAttributesValue attributeSet = assetBO.getAttributesField("Attributes").getValue();
            ArrayList<AttributeDTO> attributes = new ArrayList<AttributeDTO>();
            attributes = aAsset.getAttributes();
            for (AttributeDTO a : attributes) {
                switch (a.getAttributeType()) {
						case BIGDECIMAL:
                            System.out.println("Set the attribute value of type bigdecimal with code " + a.getCode() + " to " + a.getValue());
                            BigDecimal decimal = BigDecimal.valueOf((double) a.getValue());
							attributeSet.getBigDecimalAttribute(a.getCode()).setValue(decimal);
							break;
						case INTEGER:
                            System.out.println("Set the attribute value with code " + a.getCode() + " to " + a.getValue());
                            attributeSet.getIntegerAttribute(a.getCode()).setValue((Integer)a.getValue());
							break;
						case SINGLESELECT:
                            System.out.println("Set the attribute value of type single select with code " + a.getCode() + " to " + a.getValue());
                            attributeSet.getSingleSelectAttribute(a.getCode()).setValue((String)a.getValue());
							break;
						case DATE:
                            System.out.println("Set the attribute value of type date with code " + a.getCode() + " to " + a.getValue());
                            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                            String dateString = String.valueOf(a.getValue());
                            Date date = (Date) simpleDate.parse(dateString);
                            attributeSet.getDateAttribute(a.getCode()).setValue(date);
							break;
						case DATETIME:
                            System.out.println("Set the attribute value of type datetime with code " + a.getCode() + " to " + a.getValue());
                            SimpleDateFormat simpleDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String dateTimeString = String.valueOf(a.getValue());
                            Date dateTime = (Date) simpleDateTime.parse(dateTimeString);
							attributeSet.getDateTimeAttribute(a.getCode()).setValue(dateTime);
							break;
                        case TIME:
                            System.out.println("Set the attribute value of type time with code " + a.getCode() + " to " + a.getValue());
                            Time time = Time.valueOf((String)a.getValue());
                            attributeSet.getDateAttribute(a.getCode()).setValue(time);
							break;
						default:
							System.out.println("Set the attribute value of type string or multiline with code " + a.getCode() + " to " + a.getValue());
                            attributeSet.getAttribute(a.getCode()).setValue(a.getValue());
							break;
                }
            }
        }
        assetBO.executeSave();

    }
        

    public AssetDTO createAssetDetailRecord(final IDataService dataService, final AssetCreateDTO aAsset) throws ActionNotFoundException, BusinessException, FieldNotFoundException, IllegalStateException, IOException {
        IActionListManager actionListManager = dataService.getActionListManager("UsrAsset"); 
        IAction actionCreate = actionListManager.getAction("BomAdd");
        IBusinessObject assetBO = actionCreate.execute();
        AssetDTO asset = null;

        if(aAsset.getDescription() != null) {
            System.out.println("Set Description for Asset to " + aAsset.getDescription());
            assetBO.getStringField("Name").setValue(aAsset.getDescription());
        }
        if(aAsset.getProperty() != null) {
            System.out.println("Set Property for Asset to " + aAsset.getProperty());
            assetBO.getReferenceField("PropertyRef").setValue(aAsset.getProperty());
        }
        if(aAsset.getFloor() != null) {
            System.out.println("Set Floor for Asset to " + aAsset.getFloor());
            assetBO.getIntegerField("FreeInteger1").setValue(aAsset.getFloor());
        }
        if(aAsset.getSpace() != null) {
            System.out.println("Set Space for Asset to " + aAsset.getSpace());
            assetBO.getReferenceField("SpaceRef").setValue(aAsset.getSpace());
        }
        if(aAsset.getManufacturer() != null) {
            System.out.println("Set Manufacturer for Asset to " + aAsset.getManufacturer());
            assetBO.getStringField("FreeString35").setValue(aAsset.getManufacturer());
        }
        if(aAsset.getModel() != null) {
            System.out.println("Set Model for Asset to " + aAsset.getModel());
            assetBO.getStringField("Type").setValue(aAsset.getModel());
        }
        if(aAsset.getAssetClassification() != null) {
            System.out.println("Set AssetClassification for Asset to " + aAsset.getAssetClassification());
            assetBO.getReferenceField("AssetClassificationRef").setValue(aAsset.getAssetClassification());
        }
        if(aAsset.getAssetGroup() != null) {
            System.out.println("Set AssetGroup for Asset to " + aAsset.getAssetGroup());
            assetBO.getReferenceField("ItemGroupRef").setValue(aAsset.getAssetGroup());
        }
        if(aAsset.getAssetTag() != null) {
            System.out.println("Set AssetTag for Asset to " + aAsset.getAssetTag());
            assetBO.getStringField("AssetTag").setValue(aAsset.getAssetTag());
        }
        if(aAsset.getInServiceDate() != null) {
            System.out.println("Set InServiceDate for Asset to " + aAsset.getInServiceDate());
            assetBO.getDateField("FirstUsedDate").setValue(aAsset.getInServiceDate());
        }

        assetBO.executeSave();
        asset = getAssetByCode(dataService, assetBO.getStringField("Code").getValue());
        return asset;

    }

}