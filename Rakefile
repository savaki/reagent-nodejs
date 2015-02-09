NODE = ENV['NODE'] || 'node'

namespace :lein do
  desc 'automatically recompiles cljs to js when changes are detected'
  task :watch do
    run_command 'infra/lein cljsbuild auto dev node'
  end

  desc 'compiles cljs to js once in development mode'
  task :dev do
    run_command 'infra/lein cljsbuild once dev node'
  end

  desc 'compiles cljs to js'
  task :compile do
    run_command 'infra/lein cljsbuild once prod node'
  end
end

namespace :node do
  closure_bootstrap = 'https://raw.githubusercontent.com/google/closure-library/master/closure/goog/bootstrap/nodejs.js'

  task "prepare_node" do
    basedir = "target/node/scripts"

    # download the closure nodejs bootstrap
    filename = "#{basedir}/goog/bootstrap/nodejs.js"
    unless File.exists? filename
      run_command "mkdir -p #{File.dirname filename}"
      run_command "(cd #{File.dirname filename}; curl -s -o #{File.basename filename} #{closure_bootstrap})"
    end

    # download react
    unless File.exists? "#{basedir}/react.js"
      run_command "curl -L -s -o #{basedir}/react.js http://fb.me/react-0.12.2.js"
    end

    # install express, st
    unless Dir.exists? "#{basedir}/node_modules"
      run_command "(cd #{basedir}; npm install express st)"
    end

    # copy the script file
    run_command "cp infra/server.js #{basedir}"
  end

  desc "run node in node mode"
  task :run => "prepare_node" do
    ENV['DOCROOT'] = File.expand_path(File.dirname(__FILE__) + "/target/dev")
    run_command "(cd target/node/scripts; #{NODE} server.js)"
  end
end

def run_command(command)
  puts command
  system(command) || raise("unable to execute command - #{command}")
end
