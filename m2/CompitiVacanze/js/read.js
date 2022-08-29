//READ

import { Comment } from "../export/class.js";

getUsers();

function getUsers() {
    fetch('http://localhost:3000/comments')
        .then(res => res.json())
        .then(comments => {
            for (let comment of comments) {
                new Comment(comment.id, comment.name, comment.date, comment.comment, comment.fullDate)
            }
            getLatest(comments);
        })
}

//get the latest post to add the "latest post" flag and animation
//only if the post is maximum 5 days old
function getLatest(array) {
    let latestPost = document.querySelector('.card') //mi prende l'ultimo
    let latestPostID = latestPost.id.split('-')[1];    
    let latestPostDate = array.find(obj => obj.id === latestPostID * 1).fullDate
    let nowDateMs = new Date().getTime()
    const FIVEDAYS = 86400000;
    
    if (latestPostDate + FIVEDAYS > nowDateMs) {
        let flag = document.createElement('div');
        flag.textContent = 'Latest post';
        flag.classList.add('flag');
        latestPost.classList.add('latestPost', 'slideInRight')
        latestPost.prepend(flag)
    
    } else {
        latestPost.classList.remove('latestPost', 'slideInRight')
    }
}
