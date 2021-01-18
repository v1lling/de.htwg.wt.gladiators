cd ..
cd de.htwg.wt.gladiators-vue
npm run build
echo "Frontend successfully built"
sleep 3
rm -rf ../de.htwg.wt.gladiators/public/frontend
echo "Removed old frontend"
mkdir ../de.htwg.wt.gladiators/public/frontend
cd ../de.htwg.wt.gladiators
cp -r ../de.htwg.wt.gladiators-vue/dist/* ./public/frontend
echo "Moved new frontend"
git add .
if [ -z "$1" ]
then
    git commit -m "$1"
else
    git commit -m "Automatically built frontend"
fi
git push origin
echo "Successfully pushed to github"