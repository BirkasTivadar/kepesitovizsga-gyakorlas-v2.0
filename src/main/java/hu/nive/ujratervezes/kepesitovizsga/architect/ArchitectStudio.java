package hu.nive.ujratervezes.kepesitovizsga.architect;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArchitectStudio {

    private Map<String, Plan> plans = new LinkedHashMap<>();

    public void addPlan(String title, Plan plan) {
        if (isEmpty(title) || plan == null) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        plans.put(title, plan);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public Plan getPlanWithMaxSquareMeter() {
        if (plans.values().stream().max(Comparator.comparingInt(Plan::calculateSquareMeter)).isPresent()) {
            return plans.values().stream().max(Comparator.comparingInt(Plan::calculateSquareMeter)).get();
        }
        throw new IllegalStateException("List of plans is empty");
    }

    public Plan getPlanByWorkingTitle(String workigTitle) {
        if (isEmpty(workigTitle)) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        if (!plans.containsKey(workigTitle)) {
            throw new IllegalArgumentException("No such project.");
        }
        return plans.get(workigTitle);
    }

    public Plan getPlanByProjectName(String projectName) {
        if (isEmpty(projectName)) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        List<Plan> temp = plans.values().stream().filter(plan -> plan.getProjectName().equals(projectName)).collect(Collectors.toList());
        if (temp.isEmpty()) {
            throw new IllegalArgumentException("No such project.");
        }
        return temp.get(0);
    }

    public List<Plan> getSmallerPlans(int squareMeter) {
        return plans.values().stream().filter(plan -> plan.calculateSquareMeter() < squareMeter).collect(Collectors.toList());
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        return plans.values().stream().filter(plan -> plan.getType() == type).collect(Collectors.toList());
    }
}
