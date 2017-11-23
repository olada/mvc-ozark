/**
 * Author: David Olah, Cofinpro AG
 * Date: 23.11.2017, 21:48
 */
var gulp = require("gulp");
var run = require("gulp-run");
var rename = require("gulp-rename");
var clean = require("gulp-clean");

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