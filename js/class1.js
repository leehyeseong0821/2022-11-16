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

    //생성자
    constructor(username,password,name,email){
        this.username=username;
        this.password=password;
        this.name=name;
        this.email=email;

    }
    //메소드 
    printName(){
        console.log(this.name + "님의 정보");

     
    }

}
class UserMain{
    // 싱글톤 #private
     static #instance = null;
     static getInstance(){
        if(this.#instance == null){
            this.#instance = new UserMain();
        } 
        return this.#instance;
     }



    main(){
        let user = new User("lhs5513","1234","이혜성","lhs5567@naver.com"); //유저생성
        
        // user.username = "lhs5513";
        // user.password = "1234";
        // user.name ="이혜성";
        // user.email ="lhs5567@naver.com";

        console.log(user);

        localStorage.username = user.username;
                                //전역
        console.log("username:"+localStorage.username);

        user.printName();
    }

}
window.onload= () =>{
    // let userMain = new UserMain();
    let userMain = UserMain.getInstance();

    userMain.main();
}