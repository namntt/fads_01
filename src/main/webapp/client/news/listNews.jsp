<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
	<div class="row" id="search">
		<form id="search-form" action="" method="POST"
			enctype="multipart/form-data">
			<div class="row">
				<div class="form-group col-xs-9">
					<input class="form-control" type="text" placeholder="Search" />
				</div>
				<div class="form-group col-xs-3">
					<button type="submit" class="btn btn-block btn-primary">Search</button>
				</div>
			</div>
			<div class="row" id="filter">
				<div class="form-group col-sm-3 col-xs-6">
					<select data-filter="make" class="filter-make filter form-control">
						<option value="">Select Make</option>
						<option value="">Show All</option>
					</select>
				</div>
				<div class="form-group col-sm-3 col-xs-6">
					<select data-filter="model"
						class="filter-model filter form-control">
						<option value="">Select Model</option>
						<option value="">Show All</option>
					</select>
				</div>
				<div class="form-group col-sm-3 col-xs-6">
					<select data-filter="type" class="filter-type filter form-control">
						<option value="">Select Type</option>
						<option value="">Show All</option>
					</select>
				</div>
				<div class="form-group col-sm-3 col-xs-6">
					<select data-filter="price"
						class="filter-price filter form-control">
						<option value="">Select Price Range</option>
						<option value="">Show All</option>
					</select>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="row">
	<div class="col-md-8">
		<table class="table">
			<thead>
				<tr>
					<td class="name"><s:text name="client.list.new" /></td>
				</tr>
			</thead>
			<s:iterator value="subCategory">
				<tbody>
					<tr>
						<td><s:url action="news-detail" var="news-detail">
								<s:param name="id">${id}</s:param>
							</s:url>
							<div class="title">
								<s:a href="%{news-detail}">${tittle}</s:a>
							</div>
							<div class="time">
								<s:date name="startDate" format="dd/MM/yyyy" />
							</div></td>
					</tr>
				</tbody>

			</s:iterator>
		</table>
	</div>
	<div class="col-md-4"></div>
</div>