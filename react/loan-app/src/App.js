import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {Link,Routes,Route} from 'react-router-dom';
import { CustomerLogin, CustomerRgister, CustomerSuccess } from './components/Customer.js';


function App() {
  return (
    <div className = 'container-fluid'>
    <div className = 'alert alert-secondary'>
      <h2 className = 'text-center'>Loan Application</h2>
    </div>
    <div>
       <Routes>
        <Route path = '' element = {<CustomerLogin/>}></Route>
        <Route path = '/login' element ={<CustomerLogin/>}></Route>
        <Route path = 'Register' element = {<CustomerRgister/>}></Route>
        <Route path = '/success/:emailId/*' element = {<CustomerSuccess/>}></Route>
       </Routes>
    </div>
  </div>
    
  );
}

export default App;
