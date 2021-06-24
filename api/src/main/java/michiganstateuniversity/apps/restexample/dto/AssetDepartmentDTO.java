package michiganstateuniversity.apps.restexample.dto;

public class AssetDepartmentDTO
{
    private int syscode;
    private String code;
    private String codeGroup;
    private String department;

    /**
     * @return the syscode
     */
    public int getSyscode() {
        return syscode;
    }

    /**
     * @param aSyscode the syscode to set
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
     * @param aCode the code to set
     */
    public void setCode(final String aCode) {
        code = aCode;
    }

    /**
     * @return the codeGroup
     */
    public String getCodeGroup() {
        return codeGroup;
    }

    /**
     * @param aCodeGroup the code Group to set
     */
    public void setCodeGroup(final String aCodeGroup) {
        codeGroup = aCodeGroup;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param aDepartment the Department to set
     */
    public void setDepartment(final String aDepartment) {
        department = aDepartment;
    }

}