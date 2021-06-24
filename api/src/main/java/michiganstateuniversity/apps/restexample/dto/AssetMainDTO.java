package michiganstateuniversity.apps.restexample.dto;

public class AssetMainDTO
{
    private String code;
    private String description;

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

}