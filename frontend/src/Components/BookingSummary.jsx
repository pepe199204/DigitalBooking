import React, {useState, useEffect, useContext} from 'react';
import { useNavigate } from 'react-router-dom';
import UserContext from '../context/UserContext';
import {getLocationById, publicarReserva } from '../services/Api'
import "../Styles/BookingSummary.css"

const BookingSummary = ({urlImagenPrincipal, categoria,ciudad, titulo,startDate, endDate,id ,errorMessage, setErrorMessage }) => {
    const { user,city } = useContext(UserContext);
    const [locacion,setLocacion] = useState([]);
    const checkin = startDate;
    const checkout = endDate;
    const navigate = useNavigate();
    const [isCiudad, setIsCiudad] = useState(false);



    useEffect(() => {
    if (ciudad) {
        getLocationById(ciudad.id).then((data) => {
            setLocacion(data.data);
        });
    }
    }, [ciudad]);
    
    const handleCheckin = () =>{
        if (checkin === null) {
            return ("_/_/_")
        }
        else{
            return(
                <p> {checkin.getDate() + "/" + (checkin.getMonth() +1) + "/" + checkin.getFullYear()}</p>
            )
        }
    }
    const handleCheckout = () =>{
        if (checkout === null) {
            return ("_/_/_")
        }
        else{
            return(
                <p> {checkout.getDate() + "/" + (checkout.getMonth() +1) + "/" + checkout.getFullYear()}</p>
            )
        }
    }


    useEffect(() => {
        if (city !== undefined) {
        setIsCiudad(true);
        } else if (city === undefined) {
        setIsCiudad(false);
        }
    }, [city]);

    const onSubmit = () => {
        if(checkout === null) {
            console.log("Reserva fallida");
            setErrorMessage("Por favor agregar fecha de check out");}
        else
        if (checkout !== null){
        const datecheckin=  new Date(Date.UTC(checkin.getFullYear(), checkin.getMonth(), checkin.getDate()))
        const result_datecheckin = datecheckin.toISOString().split('T')[0]
        
        const datecheckout= new Date(Date.UTC(checkout.getFullYear(), checkout.getMonth(), checkout.getDate()))
        const result_datecheckout = datecheckout.toISOString().split('T')[0]

        const newReserva={  

            fecha_checkin: result_datecheckin,
            fecha_checkout: result_datecheckout,     
            producto:{id},
            usuario:{id:user.id},
        };
        
        {if(isCiudad === true && checkout !== null){
            console.log("Reserva exitosa");
            user.ciudad=city.city;
            publicarReserva(newReserva)
            navigate(`/product/${id}/reservas/ok`);
        }else 
        if(isCiudad === false){
            console.log("Reserva fallida");

            setErrorMessage("Por favor agregar ciudad");
        }}

    }
}

    return (
        <div className="booking-summary">
        <h2>Detalle de la reserva</h2>
        <img className="product-img" src={urlImagenPrincipal} alt="img-main" />
        {titulo && 
        <div>
        <h4>{categoria.titulo}</h4>
        <h3>{titulo}</h3>
        <div className='stars'>
                <img src={require("../Images/color-star.png") } alt="icon"/>
                <img src={require("../Images/color-star.png") } alt="icon"/>
                <img src={require("../Images/color-star.png")} alt="icon"/>
                <img src={require("../Images/color-star.png")} alt="icon"/>
                <img src={require("../Images/grey-star.png")} alt="icon"/>
        </div>
        </div>
        }
        <div className="loc-left">
                <img src={require("../Images/localizador.png")} alt="icon"/>
                <div>
                    <p>{locacion.nombre}, {locacion.provincia? locacion.provincia.nombre : "Loading"}
                    , {locacion.provincia? locacion.provincia.pais.nombre : "Loading"}</p>

                
                </div>

            </div>
            <hr className='summary-line'/>
            <div className='check-box'>
            <p className='summary-check'>Check in</p>
            {handleCheckin()}
            </div>
            <hr className='summary-line'/>
            <div className='check-box'>
            <p className='summary-check'>Check out</p>
            {handleCheckout()}
            </div>
            <hr className='summary-line'/>
            <button type="submit"  onClick={onSubmit} className="button3"> Confirmar reserva</button>
        </div>
    )
}
export default BookingSummary
