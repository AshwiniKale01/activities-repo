import { useState } from "react";
import { Link,Route,Routes,useNavigate,useParams } from "react-router-dom";
import axios from "axios";




// component to success
export function CustomerSuccess(){
    let {emailId} = useParams();
    let dummyCustomer={
        firstname:"Ashwini",lastname:"kale",url:""
    }
    return(<div className="row">
            <div className="col-4">
                <img src={dummyCustomer.url} width='100' height='100'></img>
                <p> Name : {dummyCustomer.firstname}</p>
                <p> Phone : {dummyCustomer.lastname}</p>
            </div>
            <div className="col-6">
                <Link className="me-2" to='dashboard'>Dashboard</Link>
                <Link className="me-2" to='addCustomer'>Add Customer</Link>
                <Link className="me-2" to='viewCustomer'>View Customer</Link>
                <div>
                    <Routes>
                    <Route path= '' element={<div>Welcome,{emailId}</div>} ></Route>
                    <Route path= 'dashboard' element={<div>Welcome,{emailId}</div>} ></Route>
                    <Route path= 'addCustomer' element={<div>Welcome,{emailId}...you can add customer</div>} ></Route>
                    <Route path= 'viewCustomer' element={<div>Welcome,{emailId}..view customers</div>} ></Route>
                    </Routes>
                    
                </div>
            </div>
        </div>);
} 

export function CustomerRgister(){
let [firstname,setFirstName] = useState('');
let [lastname,setLastName] = useState('');
let [emailId,setEmailId] = useState('');
let [password,setPassword] = useState('');
let [phone,setPhone] = useState('');
let [pan,setPan] = useState('');
let navigate = useNavigate();
let handleSubmit = (e) =>{
    e.preventDefault();

    let Customer = {"fiestname":firstname,"lastname":lastname,"emailid":emailId,"password":password,"phone":phone,"pan":pan};
    let url ='http://localhost:9092/api/addcustomers';
    axios.post(url,Customer).then(Response => navigate('/login')).catch(err => navigate('/register'));
    // console.log(Profile);
    // navigate to login
    // navigate('/login');
};
return(<div className="container">
    <h3>Registration Form</h3>
    <form onSubmit={handleSubmit}>
        <div className="w-25">
            <label>Enter Your First Name</label>
            <input className="form-control mb-2 mt-3" type="firstname" onChange={(e)=>setFirstName(e.target.value)}></input>
        </div>
        <div className="w-25">
            <label>Enter Your Last Name</label>
            <input className="form-control mb-2 mt-3" type="lastname" onChange={(e)=>setLastName(e.target.value)}></input>
        </div>
        <div className="w-25">
            <label>Enter Email Id</label>
            <input className="form-control mb-2 mt-3" type="email" onChange={(e)=>setEmailId(e.target.value)}></input>
        </div>
        <div className="w-25">
            <label>Enter Your Password</label>
            <input className="form-control mb-2 mt-3" type="password" onChange={(e)=>setPassword(e.target.value)}></input>
        </div>
        <div className="w-25">
            <label>Enter Your Phone No</label>
            <input className="form-control mb-2 mt-3" type="phone" onChange={(e)=>setPhone(e.target.value)}></input>
        </div>
        <div className="w-25">
            <label>Enter Your Pan No</label>
            <input className="form-control mb-2 mt-3" type="pan" onChange={(e)=>setPan(e.target.value)}></input>
        </div>
        <div>
            <input type='submit' value='Register' className="btn btn-warning mb-2"></input>
        </div>
    </form>
    <div>
        <Link to='/login'>Login</Link>
    </div>
</div>)
}

// components to login
export function CustomerLogin(){
    let [emailId,setEmailId] = useState('');
    let[password,setPassword] = useState('');
    // to programmtically navigate 
    let navigate = useNavigate();
    // authenticate the emildId and password
    let handleSubmit = (e) => {
        e.preventDefault();
        //url: /success/emailId
        //   navigate('/success/'+emailId);  
        let LoginData = {"emailid":emailId,"password":password};
        let url = 'http://localhost:9092/api/login';
        axios.post(url,LoginData).then(response => console.log(response)).catch(err => navigate('/login'));

        
    };
    return(<div className="container">
        <h3>Login Form</h3> <hr/>
        <form onSubmit={handleSubmit}>
            <div className="w-25">
                <input type = 'text' placeholder="Enter your Email"  className="form-control"
                onChange={e => setEmailId(e.target.value)}></input>
            </div>
            <div className="w-25">
                <input type = 'password' placeholder="Enter your Password"  className="form-control"
                onChange={e => setPassword(e.target.value)}></input>
            </div>
            <div>
                <input type ='submit' className="btn btn-secondary" value = 'Login'></input>
            </div>
        </form>
        <div>
            <Link to = '/register'>Register Profile</Link>
        </div>
    </div>)
}

