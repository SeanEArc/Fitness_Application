import { Link } from "react-router";

const LandingPage = () => {

      

      return (

            <div>
                  <h1> THIS IS A LANDING PAGE </h1>
                  <p> This is the landing page for my fitness application.</p>
                  <Link to="/LogIn" className="bg-black w-[150px] h-[50px] mt-5"> User Log in </Link>
            </div>
      )



}

export default LandingPage;