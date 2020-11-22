package tests;

import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import models.Project;
import models.TestSuite;
import org.testng.annotations.Test;

public class QaseTest {

    @Test
    public void testCreateProjectCreateTestSuiteDeleteTestSuit() {
        Project project = Project.builder()
                .title("MikhailKlim")
                .access("all")
                .code("KLIM")
                .group(null)
                .description("Dmitry's project")
                .build();
        String code = new ProjectsAdapter().create(project);

        TestSuite suite = TestSuite.builder()
                .title("MikhailK Suite")
                .description("bla bla")
                .preconditions("precond")
                .build();
        int id = new SuiteAdapter().create(code, suite);

        new SuiteAdapter().delete(code, id);
    }
}
