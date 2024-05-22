import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import RegistroProveedores from './components/auth/RegistroProveedores';
import NavBar from './components/NavBar';
import Home from './components/pages/Home';

function App() {
  return (
    <div className='bg-lime-900 '>
      <Router>
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/registroProveedores" element={<RegistroProveedores />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
