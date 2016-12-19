package com.github.pabadzdzwiagief.pamflet;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import pamflet.Pamflet;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.SITE)
public final class PamfletGenerateMojo extends AbstractMojo {
    @Parameter(required = true, defaultValue = "src/site")
    private File baseSourceDirectory;

    @Parameter(required = true, defaultValue = "${project.build.directory}/site")
    private File outputDirectory;

    public void execute() throws MojoExecutionException {
        ensureOutputDirectoryExistsOrThrow();
        Pamflet.main(new String[]{baseSourceDirectory.toString(), outputDirectory.toString()});
    }

    private void ensureOutputDirectoryExistsOrThrow() throws MojoExecutionException {
        if (outputDirectory.exists()) {
            return;
        }
        if (outputDirectory.mkdirs()) {
            return;
        }
        throw new MojoExecutionException(
            "Cannot create " + outputDirectory.getAbsolutePath()
        );
    }
}
