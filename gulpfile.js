/**
 * Author: David Olah, Cofinpro AG
 * Date: 23.11.2017, 21:48
 */
var gulp = require("gulp");
var run = require("gulp-run");
var rename = require("gulp-rename");
var clean = require("gulp-clean");

/**
 * Pipeline:
 * - Delete ./presentation/index.html (so we can easily replace it)
 * - Copy ./slides/slides.html to ./presentation/slides.html
 * - Rename ./presentation/slides.html in ./presentation/index.html
 * - Call npm start within ./presentation (spawns webserver displaying the presentation)
 */

gulp.task("delete-default-presentation-index-file", function() {
    console.log("Deleting ./presentation/index.html file");
    return gulp.src("./presentation/index.html")
            .pipe(clean({force: true}))
});

gulp.task("copy-slides.html", ["delete-default-presentation-index-file"], function() {
    console.log("Copying slides.html from ./slides/ to ./presentation/");
    return gulp.src("./slides/slides.html")
        .pipe(gulp.dest("./presentation/"));
});

gulp.task("clean-presentation-etc-folder", function() {
    console.log("Cleaning ./presentation/etc/");
    return gulp.src("./presentation/etc/")
        .pipe(clean());
});

gulp.task("copy-images-to-presentation-etc", ["clean-presentation-etc-folder"], function() {
    console.log("Copying images folder from ./slides/ to ./presentation/etc/");
    return gulp.src(["./slides/**/*", "!./slides/*"], {"base": "slides"})
        .pipe(gulp.dest("./presentation/etc/"))
});

gulp.task("rename-slides-to-index-in-presentation-folder", ["copy-slides.html"], function() {
    console.log("Renaming ./presentation/slides.html to index.html");
    return gulp.src("./presentation/slides.html")
        .pipe(rename("index.html"))
        .pipe(gulp.dest("./presentation"));
});

gulp.task("present", ["rename-slides-to-index-in-presentation-folder", "copy-images-to-presentation-etc"], function() {
    console.log("Starting local server to serve presentation on localhost:8000");
    return run("npm --prefix ./presentation run start").exec();
});

// If changes are made to any file within the ./slides/ directory, we will make sure that our pipeline is triggered again
// That way, we only have to refresh the already running browser tab to retrieve the new presentation
var watcher = gulp.watch("./slides/**", ["rename-slides-to-index-in-presentation-folder", "copy-images-to-presentation-etc"]);