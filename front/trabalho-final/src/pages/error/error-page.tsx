import { useRouteError } from 'react-router-dom'

export default function ErrorPage(){
    
    const error = useRouteError();

    console.error(error);

    return(
        <div className='flex flex-col'>
            <div>OPA!</div>
            <img src="/src/assets/xaropinho.webp" alt="RAPAAAIS" />
        </div>
    )
}