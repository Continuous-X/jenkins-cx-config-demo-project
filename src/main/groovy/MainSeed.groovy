import jenkins.model.Jenkins
import com.cloudbees.hudson.plugins.folder.Folder
import com.synopsys.arc.jenkins.plugins.ownership.OwnershipDescription
import org.jenkinsci.plugins.ownership.model.folders.FolderOwnershipHelper

String demoProjectName = 'DemoProject'

println("=== Initialize the Demo folder")
if (Jenkins.getInstanceOrNull().getItem(demoProjectName) != null) {
    println("${demoProjectName} folder has been already initialized, skipping the step")
} else {
    def demoFolder = Jenkins.getInstanceOrNull().createProject(Folder.class, demoProjectName)
    demoFolder.description = "Demo Pipeline jobs"
    FolderOwnershipHelper.setOwnership(demoFolder, new OwnershipDescription(true, "user"))
}