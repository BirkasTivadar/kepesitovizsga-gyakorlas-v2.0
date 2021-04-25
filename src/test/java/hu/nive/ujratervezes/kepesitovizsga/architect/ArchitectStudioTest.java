package hu.nive.ujratervezes.kepesitovizsga.architect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArchitectStudioTest {

    private ArchitectStudio studio;

    @BeforeEach
    public void setUp() {
        ResidentialBuildingPlan residential1 = new ResidentialBuildingPlan("Budapest, Lejtő u. 20.", House.FAMILY_HOUSE, 1, 70);
        ResidentialBuildingPlan residential2 = new ResidentialBuildingPlan("Budapest, Zólyomi u. 12.", House.APARTMENT_BUILDING, 4, 100);
        ResidentialBuildingPlan residential3 = new ResidentialBuildingPlan("Érd, Vereckei u. 79.", House.FAMILY_HOUSE, 1, 60);
        PublicBuildingPlan public1 = new PublicBuildingPlan("Bölcsőde, Biatorbágy", 1, 350);
        PublicBuildingPlan public2 = new PublicBuildingPlan("Sportpálya öltözője, Baracska", 1, 100);
        PublicBuildingPlan public3 = new PublicBuildingPlan("Kollégium, Győr", 5, 600);
        IndustrialBuildingPlan industrial1 = new IndustrialBuildingPlan("Tűzoltóság, Déli Pályaudvar", 250, 1, 300);
        IndustrialBuildingPlan industrial2 = new IndustrialBuildingPlan("Lovarda, Pannonhalma", 50, 2, 500);
        IndustrialBuildingPlan industrial3 = new IndustrialBuildingPlan("Autószerelő műhely, Vál", 60, 1, 300);

        studio = new ArchitectStudio();
        studio.addPlan("Lajos", residential1);
        studio.addPlan("Biabölcsi", public1);
        studio.addPlan("tűzoltóság", industrial1);
        studio.addPlan("Zólyomi", residential2);
        studio.addPlan("sportöltöző", public2);
        studio.addPlan("lovarda", industrial2);
        studio.addPlan("Szalay", residential3);
        studio.addPlan("koli", public3);
        studio.addPlan("NaVál", industrial3);
    }

    @Test
    void testAddPlanWithEmptyWorkingTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.addPlan(null, new PublicBuildingPlan("Üzlethelyiség, Kukutyin", 1, 60)));
        assertEquals("Working title and plan must not be empty!", ex.getMessage());
    }

    @Test
    void testAddPlanWithEmptyPlan() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.addPlan("kiskastély", null));
        assertEquals("Working title and plan must not be empty!", ex.getMessage());
    }

    @Test
    void testGetPlanWithMaxSquareMeter() {
        assertEquals("Kollégium, Győr", studio.getPlanWithMaxSquareMeter().getProjectName());
        assertEquals(3000, studio.getPlanWithMaxSquareMeter().calculateSquareMeter());
    }

    @Test
    void testGetPlanByWorkingTitle() {
        assertEquals("Bölcsőde, Biatorbágy", studio.getPlanByWorkingTitle("Biabölcsi").getProjectName());
    }

    @Test
    void testGetPlanByEmptyWorkingTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.getPlanByWorkingTitle(""));
        assertEquals("Working title must not be empty!", ex.getMessage());
    }

    @Test
    void testGetPlanByUnknownWorkingTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.getPlanByWorkingTitle("kiskastély"));
        assertEquals("No such project.", ex.getMessage());
    }

    @Test
    void testGetPlanByProjectName() {
        assertEquals(550, studio.getPlanByProjectName("Tűzoltóság, Déli Pályaudvar").calculateSquareMeter());
        assertEquals(PlanType.INDUSTRIAL, studio.getPlanByProjectName("Tűzoltóság, Déli Pályaudvar").getType());
    }

    @Test
    void testGetPlanByEmptyProjectName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.getPlanByProjectName("\n"));
        assertEquals("Project name must not be empty!", ex.getMessage());
    }

    @Test
    void testGetPlanByUnknownProjectName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.getPlanByProjectName("Varroda, Kukutyin"));
        assertEquals("No such project.", ex.getMessage());
    }

    @Test
    void testGetSmallerPlans() {
        List<Plan> smaller = studio.getSmallerPlans(101);

        assertEquals(3, smaller.size());
    }

    @Test
    void testGetListOfPlansByPlanType() {
        List<Plan> industrials = studio.getListOfPlansByPlanType(PlanType.INDUSTRIAL);

        assertEquals(3, industrials.size());
    }

    @Test
    void testGetListOfPlansByEmptyPlanType() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> studio.getListOfPlansByPlanType(null));
        assertEquals("Parameter must not be null!", ex.getMessage());
    }

}