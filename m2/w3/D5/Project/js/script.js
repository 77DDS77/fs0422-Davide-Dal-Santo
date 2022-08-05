window.onload = getUsers();

function getUsers() {

    fetch("./users.json")
        .then(res => res.json())
        .then(users => {
            for (let user of users) {

                user = new User(user.username, user.firstName, user.lastName, 
                    user.gender, user.profileURL, user.email, user)

            }

        })

}


import {User} from '../export/class.js';
