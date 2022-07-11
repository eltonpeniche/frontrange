import { Button } from "antd";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Ilancamentos, IPaginacao } from "../../context/AuthProvider/types"

import style from './ListaLancamentos.module.scss';


export const ListaLancamentos = () => {
   const[lancamentos, setLancamentos] = useState<Ilancamentos[]>([])
   const[proxPagina, setproxPagina] = useState('')
   
   
   useEffect( () => {
        //obter lista de lancamentos
        let i = 0;
        axios.get<IPaginacao<Ilancamentos>>('http://localhost:8080/lancamentos')
            .then(resposta => {
                setLancamentos(resposta.data.content)
                
                if(!resposta.data.last){
                    const aux  = "http://localhost:8080/lancamentos?page=" + Number(resposta.data.number + 1)
                    setproxPagina(aux)
                }else{
                    setproxPagina("")
                }
                
                localStorage.setItem('l', JSON.stringify(resposta.data.content));
                localStorage.setItem('p', proxPagina);

            }).catch(erro => {
                console.log(erro)
            })
            

    }, [])

const verMais = () =>{
    axios.get<IPaginacao<Ilancamentos>>(proxPagina)
    .then(resposta => {
        setLancamentos([...lancamentos,...resposta.data.content])
        if(!resposta.data.last){
            const aux  = "http://localhost:8080/lancamentos?page=" + Number(resposta.data.number + 1)
            setproxPagina(aux)
        }else{
            setproxPagina("")
        }

        localStorage.setItem('l', JSON.stringify(resposta.data.content));
        localStorage.setItem('p', proxPagina);


    }).catch(erro => {
        console.log(erro)
    })
}
    return (<section>

        <ul>
        {lancamentos?.map( (lancamentos) => 
            <li key = { lancamentos.id }> { lancamentos.data } {' | '} { lancamentos.descricao } {' | '} { lancamentos.valor } {' | '} {lancamentos.tipolancamento}</li>
        )}
        </ul>
        {proxPagina && 
            <Button onClick={verMais}>
                Ver Mais
            </Button>}
      </section>)
};


export default ListaLancamentos