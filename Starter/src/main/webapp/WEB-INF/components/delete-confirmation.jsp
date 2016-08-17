<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="modal fade delete-confirmation" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
	
		<div class="modal-content">
		
			<div class="modal-header">
				<button aria-label="Close" data-dismiss="modal" class="close" type="button">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">Confirm Delete</h4>
			</div>
			
			<div class="modal-body">
				<p>You are about to delete this user which cannot be undone.</p>
				<p>Do you want to proceed?</p>
			</div>
			
			<div class="modal-footer">
				<div class="row">
					<div class="col-xs-6">
						<form:form id="" action="/users/:id" method="DELETE" class="inline">
							<button type="button" class="btn btn-block btn-danger">Delete User</button>
						</form:form>
					</div>
					<div class="col-xs-6">
						<button type="button" class="btn btn-block btn-default" data-dismiss="modal">Don't Delete</button>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div>