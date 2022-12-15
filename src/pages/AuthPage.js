import AuthForm from "../components/auth/AuthForm";
import Modal from '../components/UI/Modal';

const AuthPage = (props) => {
  return (
    <Modal>
      <AuthForm />
    </Modal>
  );
};

export default AuthPage;
