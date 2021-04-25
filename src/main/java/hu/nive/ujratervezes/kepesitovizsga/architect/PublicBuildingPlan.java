package hu.nive.ujratervezes.kepesitovizsga.architect;

public class PublicBuildingPlan implements Plan {

    private PlanType type = PlanType.PUBLIC;

    private String projectName;

    private int stock;

    private int area;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return area * stock;
    }

    @Override
    public PlanType getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
