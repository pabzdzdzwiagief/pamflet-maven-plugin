package com.github.pabadzdzwiagief.pamflet;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import pamflet.Pamflet;

@Mojo(name = "preview")
public final class PamfletPreviewMojo extends AbstractMojo {
    @Parameter(required = true, defaultValue = "src/site")
    private File sourceDirectory;

    public void execute() throws MojoExecutionException {
        Pamflet.main(new String[]{sourceDirectory.toString()});
    }
}
