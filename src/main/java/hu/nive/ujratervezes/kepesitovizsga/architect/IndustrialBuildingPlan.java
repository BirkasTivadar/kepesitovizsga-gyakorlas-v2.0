package hu.nive.ujratervezes.kepesitovizsga.architect;

public class IndustrialBuildingPlan implements Plan {

    private PlanType type = PlanType.INDUSTRIAL;

    private String projectName;

    private int areaOfOfficeBlock;

    private int stock;

    private int areaOfManufacturingHall;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManufacturingHall) {
        this.projectName = projectName;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.stock = stock;
        this.areaOfManufacturingHall = areaOfManufacturingHall;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return areaOfOfficeBlock * stock + areaOfManufacturingHall;
    }

    @Override
    public PlanType getType() {
        return type;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManufacturingHall;
    }
}
