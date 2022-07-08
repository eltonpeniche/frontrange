import React, {useState} from "react"
import { AuthProvider } from "./context/AuthProvider"
import { BrowserRouter, Route, Switch } from "react-router-dom"
import { ProtectedLayout } from "./components/protectedLayout"
import { Login } from "./components/Login"

function App() {

  return (
    <AuthProvider>
      <BrowserRouter>
        <Switch>
          <Route path="/profile" >
            <ProtectedLayout >
              <h2>Esse é o Component PROFILE</h2>
            </ProtectedLayout>
          </Route>
      
          <Route path="/login">
            <Login/>
          </Route>
                           
                              
        
      
        </Switch>
      </BrowserRouter>
    </AuthProvider>
  )
}

export default App
