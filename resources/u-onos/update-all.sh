for dir in `ls -d *`
do
   if test -d "$dir"; then
      echo "update $dir ......"
      cd $dir 
      git pull
      cd ..
   fi
done

