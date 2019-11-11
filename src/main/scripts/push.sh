#! /bin/bash

git status
read -r -p "确认提交吗(y/n): " x
if [ "$x" = "y" ] ; then
  git add .
  read -r -p "Commit message: " msg
  git commit -m "$msg"
  git push
else
  echo "n"
fi
