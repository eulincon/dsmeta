import axios from 'axios'
import { toast } from 'react-toastify'
import Icon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/requests'
import './styles.css'

function handleClick(id: number) {
	axios(`${BASE_URL}/sales/${id}/notification`).then((res) => {
		if (res.status === 200) {
			toast.info('SMS enviado com sucesso! :)')
		} else {
			toast.error('Erro ao enviar SMS! :(')
		}
	})
}

type Props = {
	saleId: number
}

function NotificationButton({ saleId }: Props) {
	return (
		<div className='dsmeta-red-btn' onClick={() => handleClick(saleId)}>
			<img src={Icon} alt='Notificar' />
		</div>
	)
}

export default NotificationButton
