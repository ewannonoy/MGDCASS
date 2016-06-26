var gulp = require('gulp');
var ts = require('gulp-typescript');
 

gulp.task('compile', function () {
	var tsProject = ts.createProject('tsconfig.json', { sortOutput: true });
    return gulp.src('app/**/*.ts')
        .pipe(ts(tsProject))
        .pipe(gulp.dest('app'));
});

gulp.task('watch', ['compile'], function() {
    gulp.watch('app/**/*.ts', ['compile']);
});