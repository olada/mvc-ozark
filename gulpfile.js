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
 * - Copy ./presentation.html to ./presentation/presentation.html
 * - Rename ./presentation/presentation.html in ./presentation/index.html
 * - Call npm start within ./presentation (spawns webserver displaying the presentation)
 */

gulp.task("delete-default-presentation-index-file", function() {
    console.log("Deleting ./presentation/index.html file");
    return gulp.src("./presentation/index.html")
            .pipe(clean({force: true}))
});

gulp.task("copy-presentation-html", ["delete-default-presentation-index-file"], function() {
    console.log("Copying presentation.html from project root folder / to /presentation/index.html");
    return gulp.src("presentation.html")
        .pipe(gulp.dest("./presentation/"));
});

gulp.task("rename-presentation-to-index-in-presentation-folder", ["copy-presentation-html"], function() {
    console.log("Renaming ./presentation/presentation.html to index.html");
    return gulp.src("./presentation/presentation.html")
        .pipe(rename("index.html"))
        .pipe(gulp.dest("./presentation"));
});

gulp.task("present", ["rename-presentation-to-index-in-presentation-folder"], function() {
    console.log("Starting local server to serve presentation on localhost:8000");
    return run("npm --prefix ./presentation run start").exec();
});

// If changes are made to presentation.html, we will make sure that our pipeline is triggered again
// That way, we only have to refresh the already running browser tab to retrieve the new presentation
var watcher = gulp.watch("./presentation.html", ["rename-presentation-to-index-in-presentation-folder"]);