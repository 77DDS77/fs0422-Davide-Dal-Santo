window.onload = getUsers();

function getUsers() {

    fetch("http://localhost:3000/users")
        .then(res => res.json())
        .then(users => {
            for (let user of users) {

                user = new User(user.username, user.firstName, user.lastName, 
                    user.gender, user.profileURL, user.email, user.id)

            }

        })

}


import {User} from '../export/class.js';
