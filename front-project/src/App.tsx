import React, {useState} from "react"
import { AuthProvider } from "./context/AuthProvider"
import { BrowserRouter, Route, Switch } from "react-router-dom"
import { ProtectedLayout } from "./components/protectedLayout"
import { Login } from "./components/Login"
import { ListaLancamentos } from "./components/listaLancamentos"



function App() {

  return (
    <AuthProvider>
      <BrowserRouter>
        <Switch>
          <Route path="/lancamentos" >
            <ProtectedLayout >
              <h2>Esse é o Component Lancamentos</h2>
            </ProtectedLayout>
            <ListaLancamentos/>
          
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
