package generics;
import java.util.*;

abstract class JobRole {
    protected String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    abstract void screenResume();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    void screenResume() {
        System.out.println(candidateName + " screened for Software Engineer role");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }

    @Override
    void screenResume() {
        System.out.println(candidateName + " screened for Data Scientist role");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }

    @Override
    void screenResume() {
        System.out.println(candidateName + " screened for Product Manager role");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void process() {
        jobRole.screenResume();
    }
}

class ResumeScreeningPipeline {

    public static void screenAll(List<? extends JobRole> roles) {
        for(JobRole role : roles) {
            role.screenResume();
        }
    }

    public static <T extends JobRole> void screenSingle(T role) {
        System.out.println("AI Screening Started");
        role.screenResume();
    }
}

public class ResumeScreeningSystem {
	public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Amit"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Neha"));
        r1.process();
        r2.process();
        System.out.println("Bulk Screening - ");
        List<JobRole> candidates = new ArrayList<>();
        candidates.add(new SoftwareEngineer("Harshita"));
        candidates.add(new DataScientist("Vanshika"));
        candidates.add(new ProductManager("Aman"));
        ResumeScreeningPipeline.screenAll(candidates);
    }
}
