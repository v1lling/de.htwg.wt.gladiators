cd ..
cd de.htwg.wt.gladiators-vue
npm run build
sleep 3
rm -rf ../de.htwg.wt.gladiators/public/frontend
mkdir ../de.htwg.wt.gladiators/public/frontend
cd ../de.htwg.wt.gladiators
cp -r ../de.htwg.wt.gladiators-vue/dist/* ./public/frontend
sleep 5
git add .
git commit -m "Automatically built frontend"
git push origin