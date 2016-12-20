final paths = [
        "target/site/js/pamflet.js",
        "target/site/Combined+Pages.html",
        "target/site/Contents+in+Depth.html",
        "target/site/Simple+Pamflet.html"
]
for (final String path : paths) {
    final pamfletFile = new File(basedir, path)
    if (!pamfletFile.isFile()) {
        throw new FileNotFoundException("Could not find generated file: " + pamfletFile.getAbsolutePath());
    }
}