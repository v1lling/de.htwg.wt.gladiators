cd ..
cd de.htwg.wt.gladiators-vue
npm run build
rm -rf ../de.htwg.wt.gladiators/frontend
mkdir ../de.htwg.wt.gladiators/frontend
cd ../de.htwg.wt.gladiators
cp -r ../de.htwg.wt.gladiators-vue/dist/* ./frontend
git add .
git commit -m "Automatically built frontend"
git push origin