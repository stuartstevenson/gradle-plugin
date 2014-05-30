package hudson.plugins.gradle.project;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.DependencyGraph;
import hudson.model.Descriptor;
import hudson.model.ItemGroup;
import hudson.model.TopLevelItem;
import hudson.plugins.gradle.build.GradleBuild;
import hudson.tasks.Builder;
import hudson.tasks.Publisher;
import hudson.util.DescribableList;
import jenkins.model.Jenkins;

/**
 * Created by stuarts on 30/05/2014.
 */
public class GradleProject extends AbstractProject<GradleProject, GradleBuild> implements TopLevelItem {

	private DescribableList<Builder,Descriptor<Builder>> prebuilders =
			new DescribableList<Builder,Descriptor<Builder>>(this);

	private DescribableList<Builder,Descriptor<Builder>> postbuilders =
			new DescribableList<Builder,Descriptor<Builder>>(this);

	protected GradleProject(ItemGroup parent, String name) {
		super(parent, name);
	}

	public DescriptorImpl getDescriptor() {
		return (DescriptorImpl) Jenkins.getInstance().getDescriptorOrDie(getClass());
	}

	@Override
	public DescribableList<Publisher, Descriptor<Publisher>> getPublishersList() {
		return null;
	}

	@Override
	protected Class<GradleBuild> getBuildClass() {
		return GradleBuild.class;
	}

	@Override
	public boolean isFingerprintConfigured() {
		return false;
	}

	@Override
	protected void buildDependencyGraph(DependencyGraph dependencyGraph) {

	}

	public DescribableList<Builder,Descriptor<Builder>> getPrebuilders() {
		return prebuilders;
	}

	public DescribableList<Builder,Descriptor<Builder>> getPostbuilders() {
		return postbuilders;
	}

	@Extension
	public static final class DescriptorImpl extends AbstractProjectDescriptor {

		@Override
		public String getDisplayName() {
			return "Gradle Project";
		}

		@Override
		public TopLevelItem newInstance(ItemGroup itemGroup, String name) {
			return new GradleProject(itemGroup, name);
		}
	}
}
