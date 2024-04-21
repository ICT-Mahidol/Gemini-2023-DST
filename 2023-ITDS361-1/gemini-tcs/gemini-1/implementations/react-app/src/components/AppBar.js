import React, { useState, useEffect } from "react";
import { Link, useLocation  } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import HomeIcon from '@mui/icons-material/Home';


export default function Appbar() {
  const [role, setRole] = useState(null);
  const location = useLocation();

  useEffect(() => {
    const storedRole = localStorage.getItem("role");
    if (storedRole) {
      setRole(storedRole);
      
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("role");
    setRole(null);

  };

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          { location.pathname === '/login' || location.pathname !== '/' && (
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
            component={Link}
            to="/"
          >
            <HomeIcon />
          </IconButton>
          )}
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Observation Control System
          </Typography>
          {location.pathname !== '/login' && (
            <>
              {role ? (
                <>
                  <Typography variant="body1" color="inherit" sx={{ mr: 2 }}>
                    Role: {role}
                  </Typography>
                  <Button color="inherit" component={Link} to="/login" onClick={handleLogout}>
                    Logout
                  </Button>
                </>
              ) : (
                <Button color="inherit" component={Link} to="/login">
                  Login
                </Button>
              )}
            </>
          )}
        </Toolbar>
      </AppBar>
    </Box>
  );
}
