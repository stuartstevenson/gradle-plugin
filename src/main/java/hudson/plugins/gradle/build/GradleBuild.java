package hudson.plugins.gradle.build;

import hudson.model.AbstractBuild;
import hudson.plugins.gradle.project.GradleProject;

import java.io.IOException;

/**
 * Created by stuarts on 30/05/2014.
 */
public class GradleBuild extends AbstractBuild<GradleProject, GradleBuild> {

	protected GradleBuild(GradleProject job) throws IOException {
		super(job);
	}

	@Override
	public void run() {

	}
}
