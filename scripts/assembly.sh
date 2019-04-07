#! /usr/bin/env sh
set -ev
artifact_name=${1}
working_dir=`pwd`

# clean up
rm -rf dist

# create a dir structure
mkdir dist
cd dist
mkdir prod
mkdir test

# construct dir with all of the files we need to run for PROD
cp ${working_dir}/Dockerfile prod/.
cp ${working_dir}/target/${artifact_name}*.jar prod/.

cd prod
zip -r ${artifact_name}-assembly-PROD.zip ./
mv ${artifact_name}-assembly-PROD.zip ../
cd ..

# construct dir with all of the files we need to run for TEST
cp ${working_dir}/Dockerfile test/.
cp ${working_dir}/target/${artifact_name}*.jar test/.

cd test
zip -r ${artifact_name}-assembly-TEST.zip ./
mv ${artifact_name}-assembly-TEST.zip ../
cd ..