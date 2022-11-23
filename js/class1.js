// let user ={
//     username: "lhs",
//     password: "1234"
// };
// console.log(user.username);
// console.log(user.password);




class User{
    username;
    password;
    name;
    email;

}
class UserMain{
    main(){
        let user = new User(); //유저생성
        
        user.username = "lhs5513";
        user.password = "1234";
        user.name ="이혜성";
        user.email ="lhs5567@naver.com";

        console.log(user);
    }

}
window.onload= () =>{
    let userMain = new UserMain();

    userMain.main();
}