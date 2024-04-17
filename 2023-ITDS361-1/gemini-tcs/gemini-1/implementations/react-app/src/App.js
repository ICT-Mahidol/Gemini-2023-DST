import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import SignUp from './components/Sign-up';
import NotFound from './components/NotFound';
import CreateObserving from './components/CreateObservingProgram';
import Home from './components/Home';
import Layout from './components/Layout';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path='login' element={<Login />} />
            <Route path="sign-up" element={<SignUp />} />
            <Route path='/create-observing/:planNo' element={<CreateObserving />} />

            <Route path='/' element={<Home />} />

            <Route path='*' element={<NotFound />} />
            <Route />
          </Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
