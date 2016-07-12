'use strict';

module.exports = function (grunt) {
    // load all grunt tasks matching the ['grunt-*', '@*/grunt-*'] patterns
    require('load-grunt-tasks')(grunt);
    // display the elapsed execution time of grunt tasks
    require('time-grunt')(grunt);

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        jshint: {
            options: {
                jshintrc: '.jshintrc',
                reporter: require('jshint-stylish'),
                force: true
            },
            target: [
                'Gruntfile.js',
                'src/main/webapp/assets/js/codes/**/*.js',
				'src/main/webapp/assets/js/login/**/*.js'
            ]
        },
        karma: {
            options: {
                configFile: 'src/test/javascript/karma.conf.js',
                browsers: ['Chrome'],
                singleRun: true,
                autoWatch: false
            },
            unit: {
                browsers: ['PhantomJS']
            }
        },
        protractor: {
            options: {
                configFile: 'src/test/javascript/protractor.conf.js',
                keepAlive: true, // If false, the grunt process stops when the test fails.
                noColor: false // If true, protractor will not use colors in its output.
            },
            singlerun: {}
        },
        concat: {
          options: {
            separator: ';'
          },
          dist: {
            src: [
                  'src/main/webapp/assets/js/**/*.module.js',
                  'src/main/webapp/assets/js/**/*.js'
            ],
            dest: 'src/main/webapp/assets/dist/<%= pkg.name %>.js'
          }
        },
        uglify: {
          options: {
            banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
          },
          dist: {
            files: {
              'src/main/webapp/assets/dist/<%= pkg.name %>.min.js': ['<%= concat.dist.dest %>']
            }
          }
        },
        watch: {
            files: ['<%= concat.dist.src %>'],
            tasks: ['build']
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask('e2e', ['protractor:singlerun']);
    grunt.registerTask('default', ['build']);
    grunt.registerTask('build', ['jshint', 'concat', 'uglify']);
    grunt.registerTask('compile', ['build', 'watch']);
    grunt.registerTask('test', ['karma:unit']);
};
