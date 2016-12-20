final paths = [
        "target/alternative/js/pamflet.js",
        "target/alternative/Combined+Pages.html",
        "target/alternative/Contents+in+Depth.html",
        "target/alternative/Simple+Pamflet.html"
]
for (final String path : paths) {
    final pamfletFile = new File(basedir, path)
    if (!pamfletFile.isFile()) {
        throw new FileNotFoundException("Could not find generated file: " + pamfletFile.getAbsolutePath());
    }
}